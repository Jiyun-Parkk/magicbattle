package magic;

import lombok.Getter;

@Getter
public class Magic {

    private int magicPower;
    private int computedMagicPower;
    private String magicName;


    public Magic(String magicName, int magicPower) {
        this.magicName = magicName;
        this.magicPower = magicPower;
    }

    public int computedPower(int age) {
        computedMagicPower = 0;
        if (age >= 80) {
            computedMagicPower = 80;
        } else if (age == 32) {
            computedMagicPower = 0;
        } else if (age >= 20) {
            computedMagicPower = 20;
        }
        computedMagicPower += magicPower;
        return computedMagicPower;
    }

    public void printEffectResult(int age) {
        if (age >= 80) {
            System.out.println("80세 이상은 공격력 +100 어드벤티지가 붙습니다.");
        } else if (age == 32) {
            System.out.println("32세는 공격력이 0으로 초기화 됩니다.");
        } else if (age >= 20) {
            System.out.println("20세 이상은 공격력 +20 어드벤티지가 붙습니다.");
        }
    }

}
