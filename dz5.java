import java.util.*;

public class dz5 {
    public static void main(String[] args) {

        System.out.println(task2("Иван Иванов, Светлана Петрова, Кристина Белова, Анна Мусина, Анна Крутова, Иван Юрин, Петр Лыков, Павел Чернов, Петр Чернышов, "+
        "Мария Федорова, Марина Светлова, Мария Савина, Мария Рыкова, Марина Лугова, Анна Владимирова, Иван Мечников, Петр Петин, Иван Ежов"));
    }
    static void task1(){
        //Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
        
        Map<String, List<Integer>> numberBook = new HashMap<>();
        
        numberBook.put("Иванов", List.of(251111, 552222));
        numberBook.put("Сидоров", List.of(25000, 55000));
        numberBook.put("Петров", List.of(252563, 0));

        System.out.println(numberBook);
    }
    static TreeMap<Integer, List<String>> task2(String s){

        /* Пусть дан список сотрудников: Иван Иванов, Светлана Петрова, Кристина Белова, Анна Мусина, Анна Крутова, Иван Юрин, Петр Лыков, Павел Чернов, Петр Чернышов,
        Мария Федорова, Марина Светлова, Мария Савина, Мария Рыкова, Марина Лугова, Анна Владимирова, Иван Мечников, Петр Петин, Иван Ежов.
        
        Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений. Отсортировать по убыванию популярности. Для сортировки использовать TreeMap*/
        
        s = s.replace(",", "");
        String[] namesAndMore = s.split(" ");
        List<String> names = new ArrayList<>();
        for (int i = 0; i < namesAndMore.length; i+=2) {
            names.add(namesAndMore[i]);
        }
        Collections.sort(names);
        System.out.println(names);
        TreeMap<Integer, List<String>> treeMap = new TreeMap<>(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2, o1);
            }
        });

        int count = 1;
        
        for (int i = 1; i < names.size(); i++) {
            if (names.get(i).equals(names.get(i-1))) {
                count++;
            }else{
                if (count != 1) {
                    if (treeMap.containsKey(count)) {
                        List<String> listNew = treeMap.get(count);
                        listNew.add(names.get(i-1));
                    }else{
                        List<String> list = new ArrayList<>();
                        list.add(names.get(i-1));
                        treeMap.put(count, list);
                    }
                }
                count = 1;
            }
        }

        return treeMap;
    }

    


}
