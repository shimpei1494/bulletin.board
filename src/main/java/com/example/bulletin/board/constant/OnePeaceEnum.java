package com.example.bulletin.board.constant;

import com.example.bulletin.board.model.dto.ClueDto;

import java.util.EnumSet;
import java.util.List;

// 麦わらの一味の列挙子を作成し、列挙子には船員名・船員番号・役割・得意技を設定する
// 船員番号は船員を識別する番号を1から順番につける
// 役割は船長・剣士・航海士・狙撃手・料理人・船医・考古学者・船大工・音楽家・操舵手の10種類
public enum OnePeaceEnum {
    LUFFY(1, "船長", "ゴムゴムのピストル", true),
    ZORO(2, "剣士", "三千世界", false),
    NAMI(3, "航海士", "サンダーボルトテンポ", false),
    USOPP(4, "狙撃手", "ウソップパウンド", false),
    SANJI(5, "料理人", "ディアブルジャンブ", false),
    CHOPPER(6, "船医", "ホーンポイント", true),
    ROBIN(7, "考古学者", "ミルフルール", true),
    FRANKY(8, "船大工", "ガオンキャノン", false),
    BROOK(9, "音楽家", "ソウルソリッド", true),
    JINBEI(10, "操舵手", "魚人空手", false);

    private int num;
    private String role;
    private String specialMove;

    private boolean hasEatenDevilFruits;

    // 3強メンバー確認用EnumSet
    private static final EnumSet<OnePeaceEnum> threeStrongClue = EnumSet.of(LUFFY, ZORO, SANJI);

    private OnePeaceEnum(int num, String role, String specialMove, boolean hasEatenDevilFruits) {
        this.num = num;
        this.role = role;
        this.specialMove = specialMove;
        this.hasEatenDevilFruits = hasEatenDevilFruits;
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

    // 全ての列挙子のクルー名を文字列のListで出力するメソッド
    public static List<String> getClueNameList() {
        // OnePeaceEnum.values()で列挙子の配列（これ→[]）を取得できる
        List<OnePeaceEnum> enumList = List.of(OnePeaceEnum.values());
        List<String> clueNameList = enumList.stream()
                .map(OnePeaceEnum::toString)
                .toList();
        return clueNameList;
    }

    public static List<ClueDto> getClueInfoList() {
        List<OnePeaceEnum> enumList = List.of(OnePeaceEnum.values());
        List<ClueDto> clueInfoList = enumList.stream()
                .map(onePeaceEnum -> new ClueDto(
                        onePeaceEnum.toString(),
                        onePeaceEnum.getNum(),
                        onePeaceEnum.getRole(),
                        onePeaceEnum.getSpecialMove()
                ))
                .toList();
        return clueInfoList;
    }

    // LUFFY、ZORO、SANJIのいずれかであるかを確認するメソッド
    public static boolean isLuffyZoroSanji(OnePeaceEnum onePeaceEnum) {
        // 以下のコメントアウトのようにまたはで書くこともできるが、
        // return onePeaceEnum == LUFFY || onePeaceEnum == ZORO || onePeaceEnum == SANJI;
        // 数が増えた場合などには以下のようにEnumSetを使うと便利
        return threeStrongClue.contains(onePeaceEnum);
    }

    // 悪魔の実の能力者かどうかを判別
    public boolean hasEatenDevilFruits() {
        return hasEatenDevilFruits;
    }

}
