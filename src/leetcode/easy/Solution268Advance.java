package leetcode.easy;

/**
 * Write a function:
 * class Solution { public int solution(int[] A); }
 * that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
 * For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
 * Given A = [1, 2, 3], the function should return 4.
 * Given A = [−1, −3], the function should return 1.
 * Write an efficient algorithm for the following assumptions:
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [−1,000,000..1,000,000].
 */

import java.util.Iterator;
import java.util.TreeSet;

public class Solution268Advance {

    public static void main(String[] args) {

        Solution268Advance sol = new Solution268Advance();
        int[] a = {-1000, -999, -998, -997, -996, -995, -994, -993, -992, -991, -990, -989, -988, -987, -986, -985, -984, -983, -982, -981, -980, -979, -978, -977, -976, -975, -974, -973, -972, -971, -970, -969, -968, -967, -966, -964, -963, -962, -961, -960, -959, -958, -957, -956, -955, -954, -953, -952, -951, -950, -949, -948, -947, -946, -945, -944, -943, -942, -941, -940, -939, -938, -937, -936, -935, -934, -933, -932, -931, -930, -929, -928, -927, -926, -925, -924, -923, -922, -921, -920, -919, -918, -917, -916, -915, -914, -913, -912, -911, -910, -909, -908, -907, -906, -905, -904, -903, -902, -901, -900, -899, -898, -897, -896, -895, -894, -893, -892, -891, -890, -889, -888, -887, -886, -885, -883, -882, -881, -880, -879, -878, -877, -876, -875, -874, -873, -872, -871, -870, -869, -868, -867, -866, -865, -864, -863, -862, -861, -860, -859, -858, -857, -856, -855, -854, -853, -852, -851, -850, -848, -847, -846, -845, -844, -843, -842, -841, -840, -839, -838, -837, -836, -835, -834, -833, -832, -831, -830, -829, -828, -827, -826, -825, -824, -823, -822, -821, -820, -819, -818, -817, -816, -815, -814, -813, -812, -811, -810, -809, -808, -807, -806, -805, -804, -803, -802, -801, -800, -799, -798, -797, -796, -795, -794, -793, -792, -791, -790, -789, -788, -787, -786, -785, -784, -783, -782, -781, -780, -779, -778, -777, -776, -775, -774, -773, -772, -771, -770, -769, -768, -767, -766, -765, -764, -763, -762, -761, -760, -759, -758, -757, -756, -755, -754, -753, -752, -751, -750, -749, -748, -747, -746, -745, -744, -743, -742, -741, -740, -739, -738, -737, -736, -735, -734, -733, -732, -731, -730, -729, -728, -727, -726, -725, -724, -723, -722, -721, -720, -719, -718, -717, -716, -715, -714, -713, -712, -711, -710, -709, -708, -707, -706, -705, -704, -703, -702, -701, -700, -699, -698, -697, -696, -695, -694, -693, -692, -691, -690, -689, -688, -687, -686, -685, -684, -683, -682, -681, -680, -679, -678, -677, -676, -675, -674, -673, -672, -671, -670, -669, -668, -667, -666, -665, -664, -663, -662, -661, -660, -659, -658, -657};


        int missingElement = sol.solution(a);
        System.out.println(missingElement);
    }

    public int solution(int[] A) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        int next = 0;
        int current = 0;

        if (A.length == 1) {
            return A[0] < 1 ? 1 : A[0] + 1;
        }

        for (int i = 0; i < A.length; i++) {
            treeSet.add(A[i]);
        }
        System.out.println(treeSet);

        Iterator<Integer> itr = treeSet.iterator();
        current = itr.next();
        while (itr.hasNext()) {
            next = itr.next();

            //   System.out.println(next);
            if (next != current + 1) {
                return current + 1 > 0 ? current + 1 : 1;
            }
            current = next;
        }
        if (next < 0)
            return -1;
        return next < 0 ? 1 : next + 1;
    }

}

