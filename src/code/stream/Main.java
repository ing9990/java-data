package code.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author TaeWK
 */
public class Main {
    public static void main(String[] args) {

        // 객체 배열 확인해서 걸러내기 (code.stream().filter(람다식 조건))
        List<People> femaleList =
                People
                        .getPeopleList()
                        .stream()
                        .filter( (data) ->
                                data.getGender() == 2)
                        .collect(Collectors
                                .toList());
        System.out.println("Gender == 2 List ");
        femaleList.forEach(System.out::println);


        // 나이로 정렬 ( code.stream().sorted(Comapartor.comparing(Class::GetMethod))
        List<People> sortedList = People
                .getPeopleList()
                .stream()
                .sorted(Comparator.comparing(People::getAge))
                .collect(Collectors.toList());

        System.out.println("\nAGE ASC SORTED LIST");
        sortedList.forEach(System.out::println);


        // 삼항연산자와 allMatch를 사용해서 배열안의 모든 조건이 맞는지 확인하기.
        System.out.println("\nAGE > 10 code.stream, allMatch");
        System.out.println(People.getPeopleList().stream().allMatch(
                (data)-> data.getAge() > 10) ? "모든 사람의 나이가 11살 이상입니다." : "모든 사람의 나이가 10살 이하입니다.");

        System.out.println("\nAGE > 10 code.stream, anyMatch");
        System.out.println(People.getPeopleList().stream().anyMatch(
                (data) -> data.getAge() < 10) ? "나이가 11살 미만인 사람이 한 사람도 없습니다." : "나이가 11살 이상인 사람이 한 사람 이상입니다."
        );

        // 같은 방식으로 noneMatch도 있다. -> 하나도 없을 경우 true
        System.out.println("\ncode.stream max로 가장 나이가 많은 사람의 이름을 가져온다.");
        Optional<People> maxAgePeople = People.getPeopleList().stream().max(Comparator.comparing(People::getAge));
        if(maxAgePeople.isPresent())
            System.out.println("나이가 가장 많은 사람은 " + maxAgePeople.get().getName());


        System.out.println("\ncode.stream min으로 가장 나이가 적은 사람의 이름");
        Optional<People> minAgePeople = People.getPeopleList()
                .stream().min(Comparator.comparing(People::getAge));
        if(minAgePeople.isPresent()) System.out.println("나이가 가장 많은 사람은 "+ maxAgePeople.get().getName());


        System.out.println("\n이름 순서 정배열");
        ArrayList<People> sortedPeople = (ArrayList<People>) People.getPeopleList()
                .stream().sorted(Comparator.comparing(People::getName)).collect(Collectors.toList());
        System.out.println("나이 순서로 정배열을 하면" + sortedPeople);


    }
}
