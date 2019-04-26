package rubicsCube.situation.searcher;

import rubicsCube.situation.State;
import rubicsCube.situation.checker.StateChecker;
import rubicsCube.situation.generator.StatesGenerator;
import rubicsCube.utils.ByteArrayComparator;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public abstract class AbstractSearch implements SearchEngine {
    
    protected boolean isFinished;
    protected int currentStep;
    protected StateChecker checker;
    protected StatesGenerator generator;
    
    protected Map<byte[], State> searchTree;
    
    @Override
    public Map<byte[], State> getSearchTree() {
        return searchTree;
    }
    
    @Override
    public void reset(StateChecker checker, StatesGenerator generator) {
        this.checker = checker;
        this.generator = generator;
        
        isFinished = false;
        currentStep = 0;
        
        searchTree = new TreeMap(new ByteArrayComparator());
    }
    
    protected void fillTree(Map<byte[], State> treeMap, State parentNode,
                            List<State> childNodes) {
        byte[] bytes;
        byte[] stateKey = getParentKey(treeMap, parentNode);
        
        for (State someState : childNodes) {
            bytes = new byte[stateKey.length + 1];
            for (int i = 0; i < stateKey.length; i++) {
                bytes[i] = stateKey[i];
            }
            bytes[bytes.length - 1] =
                (byte) childNodes.indexOf(someState);
            
            treeMap.put(bytes, someState);
        }
    }
    
    protected void fillTree(Map<byte[], State> treeMap, State parentNode,
                            State childNode) {
        
        byte[] stateKey = getParentKey(treeMap, parentNode);
        
        byte[] bytes = new byte[stateKey.length + 1];
        for (int i = 0; i < stateKey.length; i++) {
            bytes[i] = stateKey[i];
        }
        
        byte[] tempKey = bytes.clone();
        tempKey[tempKey.length - 2] =
            (byte) (stateKey[bytes.length - 2] + 1);
        
        int childNodeLevelKeysCount = 0;
        
        for (byte[] key : treeMap.keySet()) {
            
            Comparator comp = new ByteArrayComparator();
            
            if (comp.compare(key, bytes) >= 0 &&
                    comp.compare(key, tempKey) < 0) {
                childNodeLevelKeysCount++;
            }
        }
        
        bytes[bytes.length - 1] = (byte) (childNodeLevelKeysCount);
        treeMap.put(bytes, childNode);
        
    }
    
    private byte[] getParentKey(Map<byte[], State> treeMap, State parentNode) {
        byte[] stateKey = new byte[0];
        
        for (byte[] key : treeMap.keySet()) {
            if (treeMap.get(key).equals(parentNode)) {
                stateKey = key;
                break;
            }
        }
        return stateKey;
    }
    
}
