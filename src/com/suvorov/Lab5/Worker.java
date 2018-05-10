package com.suvorov.Lab5;

class CommonResource{
    int x=0;

    synchronized void inc()
    {
        this.x++;
        if (this.x > 2) {
            this.x = 0;
        }
        try{
            Thread.sleep(100);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}

public class Worker  extends Thread {
    private int number = -1;
    private String action = "";
    private int tree_num = 0;
    private CommonResource sync;

    @Override
    public void run() {
        for (int i = 0; i < this.tree_num; i++) {
            while(sync.x != this.number) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            sync.inc();
            System.out.printf("Workier %d makes %s on tree #%d\n", this.number, this.action, i + 1);
        }
    }

    void setNumber(int number) {
        this.number = number;
    }

    void setAction(String action) {
        this.action = action;
    }

    void setTree_num(int tree_num) {
        this.tree_num = tree_num;
    }

    void setSync(CommonResource sync) {
        this.sync = sync;
    }
}
