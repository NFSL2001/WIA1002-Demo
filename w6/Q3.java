package w6;

public class Q3{
    public static void main(String[] args) {

        MyStack<Integer> stack = new MyStack<>();
        
        { // a random stack of random number
            stack.push(342);stack.push(423);stack.push(595);stack.push(991);stack.push(462);stack.push(887);stack.push(112);stack.push(213);stack.push(627);stack.push(585);stack.push(1000);stack.push(380);stack.push(395);stack.push(107);stack.push(98);stack.push(956);stack.push(848);stack.push(833);stack.push(956);stack.push(453);stack.push(231);stack.push(930);stack.push(194);stack.push(117);stack.push(968);stack.push(411);stack.push(815);stack.push(541);stack.push(855);stack.push(101);stack.push(784);stack.push(905);stack.push(685);stack.push(878);stack.push(750);stack.push(528);stack.push(989);stack.push(54);stack.push(675);stack.push(159);stack.push(732);stack.push(358);stack.push(245);stack.push(46);stack.push(471);stack.push(924);stack.push(568);stack.push(147);stack.push(148);stack.push(707);stack.push(76);stack.push(267);stack.push(352);stack.push(586);stack.push(909);stack.push(312);stack.push(572);stack.push(191);stack.push(638);
            stack.push(342);stack.push(423);stack.push(595);stack.push(991);stack.push(462);stack.push(887);stack.push(112);stack.push(213);stack.push(627);stack.push(585);stack.push(1000);stack.push(380);stack.push(395);stack.push(107);stack.push(98);stack.push(956);stack.push(848);stack.push(833);stack.push(956);stack.push(453);stack.push(231);stack.push(930);stack.push(194);stack.push(117);stack.push(968);stack.push(411);stack.push(815);stack.push(541);stack.push(855);stack.push(101);stack.push(784);stack.push(905);stack.push(685);stack.push(878);stack.push(750);stack.push(528);stack.push(989);stack.push(54);stack.push(675);stack.push(159);stack.push(732);stack.push(358);stack.push(245);stack.push(46);stack.push(471);stack.push(924);stack.push(568);stack.push(147);stack.push(148);stack.push(707);stack.push(76);stack.push(267);stack.push(352);stack.push(586);stack.push(909);stack.push(312);stack.push(572);stack.push(191);stack.push(638);
        }

        int total = 0;
        while (!stack.isEmpty()){
            total += stack.pop();
        }
        System.out.println(total);
    }
}