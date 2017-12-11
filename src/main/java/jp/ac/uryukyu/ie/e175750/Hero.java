package jp.ac.uryukyu.ie.e175750;

public class Hero extends LivingThing {
    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     *
     * @param name      ヒーロー名
     * @param maximumHP ヒーローのHP
     * @param attack    ヒーローの攻撃力
     */

    public Hero(String name, int maximumHP, int attack) {
        super(name, maximumHP, attack);
    }

    public void wounded(int damage) {
        setHitPoint(getHitPoint() - damage);
        if (getHitPoint() < 0) {
            setDead(true);
            System.out.printf("勇者%sは道半ばで力尽きてしまった。\n", getName());
        }
    }


    @Override
    public void attack(LivingThing opponent) {
        int damage = (int) (Math.random() * getAttack());
        int random = (int) (Math.random() * 100);
        if (random < 40) {
            if (damage == 0) {
                System.out.printf("%sの攻撃！会心の一撃！！,,,だが、%sは攻撃を回避した！\n", getName(), opponent.getName(), damage);
            } else {
                System.out.printf("%sの攻撃！会心の一撃！！%sに%dのダメージを与えた！！\n", getName(), opponent.getName(), damage * 2);
                opponent.wounded(damage * 2);
            }
        } else {
            if (isDead() == false) {
                if (damage == 0) {
                    System.out.printf("%sの攻撃！,,,だが、%sは攻撃を回避した！\n", getName(), opponent.getName(), damage);
                } else {
                    System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", getName(), opponent.getName(), damage);
                    opponent.wounded(damage);
                }
            }
        }
    }
}
