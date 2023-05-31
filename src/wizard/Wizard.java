package wizard;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import magic.Magic;

/**
 * 1. 체력 마력은 1 ~ 100의 랜덤값으로 설정 2.이름과 나이를 입력받아 생성한다 3. 공격 메서드를 만든
 **/

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Wizard {

    private int hp;
    private int mp;
    private int age;
    private String name;

    public Wizard(ArrayList<Wizard> list) {
        Random random = new Random();
        hp = random.nextInt(100) + 1;
        mp = random.nextInt(100) + 1;
        String orderText = "첫번째";
        if (list.size() == 1) {
            orderText = "두번째";
        }
        Scanner sc = new Scanner(System.in);
        System.out.printf("%s 마법사의 이름을 입력해주세요. : ", orderText);
        name = sc.nextLine();
        System.out.printf("%s 마법사의 나이를 입력해주세요. : ", orderText);
        age = sc.nextInt();
        System.out.println("========================================");
    }

    public void attack(Wizard victim) {
        Magic[] listOfMagic = {new Magic("파이어볼", 20), new Magic("아이스볼", 10), new Magic("썬더볼", 30),
                new Magic("회오리바람~~", 5)};
        int random = new Random().nextInt(listOfMagic.length);
        Magic selectedMagic = listOfMagic[random];
        int victimHP = victim.getHp();
        int computeHP = victimHP - selectedMagic.computedPower(age);
        victim.setHp(computeHP);

        System.out.printf("%s(이)가 %s(을)를 %s(으)로 공격했습니다. %s공격력 %d%n", name, victim.getName(),
                selectedMagic.getMagicName(), selectedMagic.getMagicName(), selectedMagic.getMagicPower());
        selectedMagic.printEffectResult(age);
        System.out.printf("%s(이)가 데미지 %d을 받았습니다.%n", victim.getName(),
                selectedMagic.computedPower(age));
    }

    @Override
    public String toString() {
        return String.format("name: %s, age: %d", name, age);
    }

}
