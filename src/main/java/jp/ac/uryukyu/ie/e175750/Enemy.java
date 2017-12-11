package jp.ac.uryukyu.ie.e175750;

public class Enemy extends LivingThing {
    public Enemy(String name, int maximumHP, int attack) {
        super(name, maximumHP, attack);
    }
    @Override
        public void attack(LivingThing opponent) {
            int damage = (int) (Math.random() * getAttack());
            int random = (int)(Math.random()*100);
            if (random<30) {
            if (damage == 0) {
                    System.out.printf("%sの攻撃！痛恨の一撃！！,,,だが、%sは攻撃を回避した！\n", getName(), opponent.getName(), damage);
                }else{
                    System.out.printf("%sの攻撃！痛恨の一撃！！%sに%dのダメージを与えた！！\n", getName(), opponent.getName(), damage*2);
                    opponent.wounded(damage * 2);
                }
            }else{
                if (isDead() == false) {
                    if (damage == 0) {
                        System.out.printf("%sの攻撃！,,,だが、%sは攻撃を回避した！\n", getName(), opponent.getName(), damage);
                    }else{
                        System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", getName(), opponent.getName(), damage);
                        opponent.wounded(damage);
                    }
                }
            }
        }
    }

