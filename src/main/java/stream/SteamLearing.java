//package stream;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
///**
// * @author jzx
// * @email: jiazhaoxin@ule.com
// * @Date: 2019-07-19 11:44
// */
//public class SteamLearing {
//
//    public static void main(String[] args) {
//        method1();
//        String strA = " abcd ", strB = null;
//        print(strA);
//        print("");
//        print(strB);
//        getLength(strA);
//        getLength("");
//        getLength(strB);
//    }
//    public static  void method1(){
////        List<Integer> num = Arrays.asList(1, 2, 3, 4, 5);
////        List<Integer> collect = num.stream().map(n -> n - 1).filter(n -> n > 1).collect(Collectors.toList());
////        System.out.println("collect = " + collect);
//
//        Stream<List<Integer>> inputStream = Stream.of(
//                Arrays.asList(1),
//                Arrays.asList(2, 3),
//                Arrays.asList(4, 5, 6)
//        );
//        Stream<Integer> integerStream = inputStream.
//                flatMap((childList) -> childList.stream());
//
//        boolean parallel = integerStream.isParallel();
//        System.out.println("parallel = " + parallel);
//    }
//
//
//    public static void print(String text) {
//        // Java 8
//        Optional.ofNullable(text).ifPresent(System.out::println);
//        // Pre-Java 8
//        if (text != null) {
//            System.out.println(text);
//        }
//    }
//    public static int getLength(String text) {
//        // Java 8
//        return Optional.ofNullable(text).map(String::length).orElse(-1);
//        // Pre-Java 8
//// return if (text != null) ? text.length() : -1;
//    };
//}
