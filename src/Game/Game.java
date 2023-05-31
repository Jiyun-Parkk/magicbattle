package Game;

import java.util.ArrayList;
import java.util.Random;

import wizard.Wizard;

public class Game {
    Wizard player1;
    Wizard player2;
    int firstAttack;
    Wizard winner;


    public Game(ArrayList<Wizard> listOfPlayers) {
        if (listOfPlayers.size() == 2) {
            System.out.println("참가자가 2명이니 경기를 시작하겠습니다.");
            this.player1 = listOfPlayers.get(0);
            this.player2 = listOfPlayers.get(1);
            System.out.println("========================================");
            System.out.println("현재 상황 : " + player1.getName() + "의 체력: " + listOfPlayers.get(1).getHp());
            System.out.println("현재 상황 : " + player2.getName() + "의 체력: " + listOfPlayers.get(0).getHp());
            System.out.println("========================================");
        } else {
            System.out.println("참가자를 더 생성 해 주세요.");
        }
        deathMatch(listOfPlayers);
    }

    // 승자 패


    // TODO 선공자를 정한다. (method)
    public void setFirstAttacker() {
        Random whoFirst = new Random();
        this.firstAttack = whoFirst.nextInt(2);
    }

    // TODO 경기 하는 메서드 서로 공격.. (wizard list, 선공자 인덱스)
    public void deathMatch(ArrayList<Wizard> listOfPlayers) {

        setFirstAttacker();

        while (listOfPlayers.get(0).getHp() > 0 && listOfPlayers.get(1).getHp() > 0) {
            Wizard victim;
            if (firstAttack == 0) {
                victim = player2;
            } else {
                victim = player1;
            }

            listOfPlayers.get(firstAttack).attack(victim);
            System.out.println("========================================");
            System.out.println("현재 상황 : " + player1.getName() + "의 체력: " + listOfPlayers.get(1).getHp());
            System.out.println("현재 상황 : " + player2.getName() + "의 체력: " + listOfPlayers.get(0).getHp());
            System.out.println("========================================");
            if (firstAttack == 0) {
                System.out.println("0일떄");
                firstAttack = 1;
            } else {
                System.out.println("1일때");
                firstAttack = 0;
            }
        }
        if (player1.getHp() <= 0) {
            winner = player2;
        } else {
            winner = player1;
        }
        endGame();
    }

    // 선공자 부터 공격 attack
    // 한명이 체력이 다하면 쥬금 끝

    // 공격자 = 1
    // while (list.get(0).hp > 0 && player.get(1).hp > 0)

    // 공격!
    // 공격자 = 공격자 == 1 ? 2 : 1

    // TODO 승자패자 getter  (method)
    public void endGame() {
        System.out.println("경기가 끝났습니다.");
        System.out.println("승자는: " + winner);
    }

}
