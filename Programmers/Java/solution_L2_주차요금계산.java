import java.util.PriorityQueue;
import java.util.Map;
import java.util.HashMap;
import java.lang.Math;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
  class Record implements Comparable<Record> {
    String time; // 시간
    int number; // 차량번호

    public Record(String time, String number) {
      this.time = time;
      this.number = Integer.parseInt(number);
    }

    @Override
    public int compareTo(Record record) {
      return Integer.compare(this.number, record.number);
    }
  }

  public int[] solution(int[] fees, String[] records) {

    PriorityQueue<Record> qIN = new PriorityQueue<>(); // 입차 기록
    PriorityQueue<Record> qOUT = new PriorityQueue<>(); // 출차 기록
    Map<Integer, Integer> map = new HashMap<>(); // 차량별 누적 금액

    // 1. IN/OUT 분리
    for (int i = 0; i < records.length; i++) {
      String[] record = records[i].split(" ");
      if (record[2].equals("IN")) {
        qIN.offer(new Record(record[0], record[1]));
      } else {
        qOUT.offer(new Record(record[0], record[1]));
      }
    }

    while (!qOUT.isEmpty()) {
      // 2. 하나씩 꺼내서 같은 차량인지 비교
      Record in = qIN.poll();
      Record out = qOUT.peek();

      if (in.number == out.number) { // 3-1. 같은 차량일 경우
        qOUT.poll(); // 제거 후 시간 계산
        setTime(map, in.number, in.time, out.time);
      } else { // 3-2. 다른 차량일 경우
        setTime(map, in.number, in.time, "23:59"); // 23:59 출차로 간주하고 시간 계산
      }
    }

    // 4. 남은 차량 시간 계산
    while (!qIN.isEmpty()) {
      Record in = qIN.poll();
      setTime(map, in.number, in.time, "23:59");
    }

    // 5. 요금 계산
    int[] answer = new int[map.size()];
    int idx = 0;
    List<Integer> keyList = new ArrayList<>(map.keySet());
    keyList.sort((s1, s2) -> s1.compareTo(s2));
    for (Integer key : keyList) {
      answer[idx] = getFee(fees[0], fees[1], fees[2], fees[3], map.get(key));
      idx++;
    }

    return answer;
  }

  public static int getTime(String start, String end) {
    int sHour = Integer.parseInt(start.split(":")[0]);
    int sMin = Integer.parseInt(start.split(":")[1]);
    int eHour = Integer.parseInt(end.split(":")[0]);
    int eMin = Integer.parseInt(end.split(":")[1]);

    if (eMin > sMin) {
      eHour -= 1;
      eMin += 60;
    }

    return (int) ((eHour - sHour) * 60 + Math.ceil(eMin - sMin));
  }

  public static void setTime(Map<Integer, Integer> map, int number, String inTime, String outTime) {
    if (map.containsKey(number)) {
      map.put(number, map.get(number) + getTime(inTime, outTime));
    } else {
      map.put(number, getTime(inTime, outTime));
    }
  }

  // baseTime 기본 시간(분)
  // baseFee 기본 요금(원)
  // addTime 단위 시간(분)
  // addFee 단위 요금(원)
  public static int getFee(int baseTime, int baseFee, int addTime, int addFee, int time) {
    if (time - baseTime <= 0) {
      return baseFee;
    }
    return (int) (baseFee + Math.ceil((double) (time - baseTime) / addTime) * addFee);
  }
}