package com.example.bulletin.board.constant;

import java.util.Arrays;
import java.util.List;

// 麦わらの一味の列挙子を作成し、列挙子には船員名・船員番号・役割・得意技を設定する
// 船員番号は船員を識別する番号を1から順番につける
// 役割は船長・剣士・航海士・狙撃手・料理人・船医・考古学者・船大工・音楽家・操舵手の10種類
public enum OnePeaceEnum {
    LUFFY(1, "船長", "ゴムゴムのピストル"),
    ZORO(2, "剣士", "三千世界"),
    NAMI(3, "航海士", "サンダーボルトテンポ"),
    USOPP(4, "狙撃手", "ウソップパウンド"),
    SANJI(5, "料理人", "ディアブルジャンブ"),
    CHOPPER(6, "船医", "ホーンポイント"),
    ROBIN(7, "考古学者", "ミルフルール"),
    FRANKY(8, "船大工", "ガオンキャノン"),
    BROOK(9, "音楽家", "ソウルソリッド"),
    JINBEI(10, "操舵手", "魚人空手");

    private int num;
    private String role;
    private String specialMove;

    private OnePeaceEnum(int num, String role, String specialMove) {
        this.num = num;
        this.role = role;
        this.specialMove = specialMove;
    }

    public int getNum() {
        return num;
    }

    public String getRole() {
        return role;
    }

    public String getSpecialMove() {
        return specialMove;
    }

    // 全ての列挙子を文字列のListで出力するメソッドを作成
    public static List<String> getOnePeaceList() {
        List<OnePeaceEnum> enumList = List.of(OnePeaceEnum.values());
        List<String> onePeaceList = enumList.stream()
                .map(OnePeaceEnum::toString)
                .toList();
        return onePeaceList;
    }

}
