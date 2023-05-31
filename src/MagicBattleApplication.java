import java.util.ArrayList;

import java.util.Random;

import Game.Game;
import wizard.Wizard;

public class MagicBattleApplication {

    public static void main(String[] args) {

        System.out.println("마법사 배틀에 오신 것을 환영합니다!");
        System.out.println("마법사 배틀은 두명의 마법사가 경기를 합니다.");

        // TODO: 마법사 2명의 이름과 나이를 각각 입력 받는다.
        ArrayList<Wizard> listOfPlayers = new ArrayList<>();


        Wizard wizardPlayer1 = new Wizard(listOfPlayers);
        listOfPlayers.add(wizardPlayer1);
        Wizard wizardPlayer2 = new Wizard(listOfPlayers);
        listOfPlayers.add(wizardPlayer2);

        Game game = new Game(listOfPlayers);
    }

}
