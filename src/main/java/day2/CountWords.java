package day2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class CountWords {
    Map<String, Integer> map = new HashMap<>();

    public int getHero(String name) {
        return map.get(name);
    }

    public List<String> readFile(String fileName) throws IOException {
        List<String> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        while (reader.ready()) {
            list.add(reader.readLine());
        }
        reader.close();
        return list;
    }

    public Map<String, Integer> rhymes(List<String> list) {
        Map<String, Integer> countRhymes = new HashMap<>();

        int numberOfLetters = 3;
        String a = "   ";
        for (String s : list) {
            String[] words = s.trim().split("[\\s,.!?;:*()_\\-«=»{}]+");
            if (words.length < 1) {
                continue;
            }
            String last = words[words.length - 1].toLowerCase();
            if (last.length() < numberOfLetters) {
                continue;
            }
            if (last.substring(last.length() - numberOfLetters)
                    .equals(a.substring(a.length() - numberOfLetters))) {
                String key;
                if (a.compareTo(last) < 0) {
                    key = a + "_" + last;
                } else {
                    key = last + "_" + a;
                }
                countRhymes.put(key, countRhymes.get(key) == null ? 1 : countRhymes.get(key) + 1);
            }
            a = last;
        }
        return countRhymes;
    }

    public Map<String,Integer> method(Map<String, Integer> map, int minRhymes){
        Map<String, Integer> endMap = new HashMap<>();
        for (Map.Entry<String, Integer> m : map.entrySet()) {
            if(m.getValue() > minRhymes) {
                endMap.put(m.getKey(), m.getValue());
            }
        }
        return endMap;
    }


    public Map<String, Integer> method() {
        try (BufferedReader reader = new BufferedReader(new FileReader("pan-tadeusz.txt"))) {
            int numberOfLetters = 3;
            while (reader.ready()) {
                String[] line = reader.readLine().trim().split("[\\s,.!?;:*()_\\-«=»{}]+");
                for (String s : line) {
                    if (s.length() > numberOfLetters) {
                        s = s.toLowerCase();
                        map.put(s, map.get(s) == null ? 1 : map.get(s) + 1);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Integer> values = new ArrayList<>(map.values());
        Collections.sort(values, (x, y) -> y - x);
        int numberOfMostPopular = 5;
        Map<String, Integer> result = new HashMap<>();
        int countOfUniqueWords = 0;
        for (Map.Entry<String, Integer> m : map.entrySet()) {
            if (m.getValue() == 1) {
                countOfUniqueWords++;
            }
        }
        System.out.println("Liczba slow wystepujacych jeden raz to " + countOfUniqueWords);
        for (int i = 0; i < numberOfMostPopular; i++) {
            for (String s : map.keySet()) {
                if (map.get(s) == values.get(i)) {
                    result.put(s, values.get(i));
                    if (result.size() >= numberOfMostPopular) {
                        return result;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        CountWords countWords = new CountWords();
        List<String> words = countWords.readFile("testFiles/pan-tadeusz.txt");
        Map<String, Integer> rhymes = countWords.rhymes(words);
        Map<String, Integer> result = countWords.method(rhymes, 5);
        System.out.println(result);
            }

}
