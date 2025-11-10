public class IntegerSet {
    private boolean[] nums = new boolean[101];

    public IntegerSet() { }

    public static IntegerSet union(IntegerSet setA, IntegerSet setB) {
        IntegerSet unionSet = new IntegerSet();
        for (int i = 0; i <= 100; i++) {
            unionSet.nums[i] = setA.nums[i] || setB.nums[i];
        }
        return unionSet;
    }

    public static IntegerSet intersection(IntegerSet setA, IntegerSet setB) {
        IntegerSet intersectionSet = new IntegerSet();
        for (int i = 0; i <= 100; i++) {
            intersectionSet.nums[i] = setA.nums[i] && setB.nums[i];
        }
        return intersectionSet;
    }

    public void insertElem(int elem) {
        if (elem >= 0 && elem <= 100) {
            nums[elem] = true;
        }
    }

    public void deleteElem(int elem) {
        if (elem >= 0 && elem <= 100) {
            nums[elem] = false;
        }
    }

    @Override
    public String toString() {
        String result = "";
        boolean first = true;
        boolean empty = true;

        for (int i = 0; i <= 100; i++) {
            if (nums[i]) {
                empty = false;

                if (!first) {
                    result += " ";
                }

                result += i;
                first = false;
            }
        }

        if (empty) {
            return "---";
        }
        return result;
    }

    public boolean isEqualTo(IntegerSet that) {
        for (int i = 0; i <= 100; i++) {
            if (this.nums[i] != that.nums[i]) {
                return false;
            }
        }
        return true;
    }

    static void main() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();

        set1.insertElem(1);
        set1.insertElem(2);
        set1.insertElem(3);

        set2.insertElem(2);
        set2.insertElem(4);

        System.out.println("Set1: " + set1);
        System.out.println("Set2: " + set2);

        System.out.println("Union: " + union(set1, set2));
        System.out.println("Intersection: " + intersection(set1, set2));

        set1.deleteElem(10);
        System.out.println("Set1 after deleting 10: " + set1);

        System.out.println("Is Set1 equal to Set2: " + set1.isEqualTo(set2));

        IntegerSet set3 = new IntegerSet();
        System.out.println("Empty: " + set3);
    }
}
