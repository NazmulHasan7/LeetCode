// 1600. Throne Inheritance
package Medium;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Medium_1600_Throne_Inheritance {
    static class ThroneInheritance {
        String king;
        HashMap<String, List<String>> personChildrenMap;
        HashSet<String> deadPersons;

        public ThroneInheritance(String kingName) {
            // Initialization
            this.king = kingName;
            this.personChildrenMap = new HashMap<>();
            this.deadPersons = new HashSet<>();
            // Adding king to the family map
            personChildrenMap.put(king, new ArrayList<>());
        }

        public void birth(String parentName, String childName) {
            // Add child to the correspondent parent family
            if (personChildrenMap.containsKey(parentName))
                personChildrenMap.get(parentName).add(childName);
            // The newborn child could have family later
            personChildrenMap.put(childName, new ArrayList<>());
        }

        public void death(String name) {
            deadPersons.add(name);
        }

        public List<String> getInheritanceOrder() {
            List<String> order = new ArrayList<>();
            preOrder(king, order);
            return order;
        }

        private void preOrder(String parent, List<String> order) {
            if (parent != null) {
                if (!deadPersons.contains(parent))
                    order.add(parent);

                List<String> children = this.personChildrenMap.get(parent);
                for (String child : children)
                    preOrder(child, order);
            }
        }
    }
    public static void main(String[] args) {
        ThroneInheritance t= new ThroneInheritance("king"); // order: king
        t.birth("king", "andy"); // order: king > andy
        t.birth("king", "bob"); // order: king > andy > bob
        t.birth("king", "catherine"); // order: king > andy > bob > catherine
        t.birth("andy", "matthew"); // order: king > andy > matthew > bob > catherine
        t.birth("bob", "alex"); // order: king > andy > matthew > bob > alex > catherine
        t.birth("bob", "asha"); // order: king > andy > matthew > bob > alex > asha > catherine
        System.out.println(t.getInheritanceOrder()); // return ["king", "andy", "matthew", "bob", "alex", "asha", "catherine"]
        t.death("bob"); // order: king > andy > matthew > bob > alex > asha > catherine
        System.out.println(t.getInheritanceOrder());
    }
}
