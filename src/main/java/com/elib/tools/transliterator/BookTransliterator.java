package com.elib.tools.transliterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mykhaylo Fedyna
 * 
 */
public class BookTransliterator {

  private boolean eng = false;

  public String translateIntoRussian(String line) {
    line = replaceUpper(line);
    line = replaceDown(line);
    line = line.replaceAll("(__)", "");
    // System.out.println(line);
    return line;
  }

  private String replaceUpper(String word) {
    eng = false;
    List<String> array = toList(word);
    for (int i = 0; i < array.size(); i++) {
      if (array.get(i).equals("_") && array.get(i + 1).equals("_")) {
        i++;
        if (eng)
          eng = false;
        else
          eng = true;
        continue;
      }
      if (eng == true)
        continue;
      if (i < array.size() - 3 && array.get(i).equals("S") && array.get(i + 1).equals("h")
              && array.get(i + 2).equals("c") && array.get(i + 3).equals("h")) {
        array.set(i, "Щ");
        array.remove(i + 1);
        array.remove(i + 1);
        array.remove(i + 1);
        // i -= 3;
        continue;
      }
      if (i < array.size() - 1 && array.get(i).equals("S") && array.get(i + 1).equals("h")) {
        array.set(i, "Ш");
        array.remove(i + 1);
        // i--;
        continue;
      }
      if (i < array.size() - 1 && array.get(i).equals("Z") && array.get(i + 1).equals("h")) {
        array.set(i, "Ж");
        array.remove(i + 1);
        // i--;
        continue;
      }
      if (i < array.size() - 1 && array.get(i).equals("E") && array.get(i + 1).equals("\'")) {
        array.set(i, "Э");
        array.remove(i + 1);
        // i++;
        continue;
      }
      if (i < array.size() - 1 && array.get(i).equals("C") && array.get(i + 1).equals("h")) {
        array.set(i, "Ч");
        array.remove(i + 1);
        // i++;
        continue;
      }
      if (i < array.size() - 1 && array.get(i).equals("Y") && array.get(i + 1).equals("a")) {
        array.set(i, "Я");
        array.remove(i + 1);
        // i++;
        continue;
      }
      if (i < array.size() - 1 && array.get(i).equals("Y") && array.get(i + 1).equals("u")) {
        array.set(i, "Ю");
        array.remove(i + 1);
        // i++;
        continue;
      }
      if (array.get(i).equals("J")) {
        array.set(i, "Й");
        continue;
      }
      if (array.get(i).equals("C")) {
        array.set(i, "Ц");
        continue;
      }
      if (array.get(i).equals("U")) {
        array.set(i, "У");
        continue;
      }
      if (array.get(i).equals("K")) {
        array.set(i, "К");
        continue;
      }
      if (array.get(i).equals("E")) {
        array.set(i, "Е");
        continue;
      }
      if (array.get(i).equals("N")) {
        array.set(i, "Н");
        continue;
      }
      if (array.get(i).equals("G")) {
        array.set(i, "Г");
        continue;
      }
      if (array.get(i).equals("Z")) {
        array.set(i, "З");
        continue;
      }
      if (array.get(i).equals("X")) {
        array.set(i, "Х");
        continue;
      }
      if (array.get(i).equals("~")) {
        array.set(i, "Ъ");
        continue;
      }
      if (array.get(i).equals("F")) {
        array.set(i, "Ф");
        continue;
      }
      if (array.get(i).equals("Y")) {
        array.set(i, "Ы");
        continue;
      }
      if (array.get(i).equals("V")) {
        array.set(i, "В");
        continue;
      }
      if (array.get(i).equals("W")) {
        array.set(i, "В");
        continue;
      }
      if (array.get(i).equals("A")) {
        array.set(i, "А");
        continue;
      }
      if (array.get(i).equals("P")) {
        array.set(i, "П");
        continue;
      }
      if (array.get(i).equals("R")) {
        array.set(i, "Р");
        continue;
      }
      if (array.get(i).equals("O")) {
        array.set(i, "О");
        continue;
      }
      if (array.get(i).equals("L")) {
        array.set(i, "Л");
        continue;
      }
      if (array.get(i).equals("D")) {
        array.set(i, "Д");
        continue;
      }
      if (array.get(i).equals("S")) {
        array.set(i, "С");
        continue;
      }
      if (array.get(i).equals("M")) {
        array.set(i, "М");
        continue;
      }
      if (array.get(i).equals("I")) {
        array.set(i, "И");
        continue;
      }
      if (array.get(i).equals("T")) {
        array.set(i, "Т");
        continue;
      }
      if (array.get(i).equals("B")) {
        array.set(i, "Б");
        continue;
      }
    }
    return makeSting(array);
  }

  private String replaceDown(String word) {
    eng = false;
    List<String> array = toList(word);
    for (int i = 0; i < array.size() - 1; i++) {
      if (array.get(i).equals("_") && array.get(i + 1).equals("_")) {
        if (eng == true)
          eng = false;
        else
          eng = true;
      }
      if (eng == true)
        continue;
      if (i < array.size() - 3 && array.get(i).equals("s") && array.get(i + 1).equals("h")
              && array.get(i + 2).equals("c") && array.get(i + 3).equals("h")) {
        array.set(i, "щ");
        array.remove(i + 1);
        array.remove(i + 1);
        array.remove(i + 1);
        // i -= 3;
        continue;
      }
      if (i < array.size() - 1 && array.get(i).equals("s") && array.get(i + 1).equals("h")) {
        array.set(i, "ш");
        array.remove(i + 1);
        // i--;
        continue;
      }
      if (i < array.size() - 1 && array.get(i).equals("z") && array.get(i + 1).equals("h")) {
        array.set(i, "ж");
        array.remove(i + 1);
        // i--;
        continue;
      }
      if (i < array.size() - 1 && array.get(i).equals("e") && array.get(i + 1).equals("\'")) {
        array.set(i, "э");
        array.remove(i + 1);
        // i--;
        continue;
      }
      if (i < array.size() - 1 && array.get(i).equals("c") && array.get(i + 1).equals("h")) {
        array.set(i, "ч");
        array.remove(i + 1);
        // i--;
        continue;
      }
      if (i < array.size() - 1 && array.get(i).equals("y") && array.get(i + 1).equals("a")) {
        array.set(i, "я");
        array.remove(i + 1);
        // i--;
        continue;
      }
      if (i < array.size() - 1 && array.get(i).equals("y") && array.get(i + 1).equals("u")) {
        array.set(i, "ю");
        array.remove(i + 1);
        // i--;
        continue;
      }
      if (array.get(i).equals("j")) {
        array.set(i, "й");
        continue;
      }
      if (array.get(i).equals("c")) {
        array.set(i, "ц");
        continue;
      }
      if (array.get(i).equals("u")) {
        array.set(i, "у");
        continue;
      }
      if (array.get(i).equals("k")) {
        array.set(i, "к");
        continue;
      }
      if (array.get(i).equals("e")) {
        array.set(i, "е");
        continue;
      }
      if (array.get(i).equals("n")) {
        array.set(i, "н");
        continue;
      }
      if (array.get(i).equals("g")) {
        array.set(i, "г");
        continue;
      }
      if (array.get(i).equals("z")) {
        array.set(i, "з");
        continue;
      }
      if (array.get(i).equals("x")) {
        array.set(i, "х");
        continue;
      }
      if (array.get(i).equals("~")) {
        array.set(i, "ъ");
        continue;
      }
      if (array.get(i).equals("f")) {
        array.set(i, "ф");
        continue;
      }
      if (array.get(i).equals("y")) {
        array.set(i, "ы");
        continue;
      }
      if (array.get(i).equals("v")) {
        array.set(i, "в");
        continue;
      }
      if (array.get(i).equals("w")) {
        array.set(i, "в");
        continue;
      }
      if (array.get(i).equals("a")) {
        array.set(i, "а");
        continue;
      }
      if (array.get(i).equals("p")) {
        array.set(i, "п");
        continue;
      }
      if (array.get(i).equals("r")) {
        array.set(i, "р");
        continue;
      }
      if (array.get(i).equals("o")) {
        array.set(i, "о");
        continue;
      }
      if (array.get(i).equals("l")) {
        array.set(i, "л");
        continue;
      }
      if (array.get(i).equals("d")) {
        array.set(i, "д");
        continue;
      }
      if (array.get(i).equals("s")) {
        array.set(i, "с");
        continue;
      }
      if (array.get(i).equals("m")) {
        array.set(i, "м");
        continue;
      }
      if (array.get(i).equals("i")) {
        array.set(i, "и");
        continue;
      }
      if (array.get(i).equals("t")) {
        array.set(i, "т");
        continue;
      }
      if (array.get(i).equals("\'")) {
        array.set(i, "ь");
        continue;
      }
      if (array.get(i).equals("b")) {
        array.set(i, "б");
        continue;
      }
    }
    return makeSting(array);
  }

  private String makeSting(List<String> array) {
    String word = "";
    for (int i = 0; i < array.size(); i++) {
      word += array.get(i);
    }
    return word;
  }

  private List<String> toList(String word) {
    List<String> list = new ArrayList<String>();
    char[] array = word.toCharArray();
    for (int i = 0; i < array.length; i++) {
      list.add(array[i] + "");
    }
    return list;
  }

  /*
   * public static void main(String[] args) { Transliterator t = new Transliterator();
   * t.translateIntoRussian(" shch e r t y u i o p a s d f g j k l ' z x c v b n m ya yu e' zh ch sh"); }
   */
}
