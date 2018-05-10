package com.suvorov.Lab5;

public class Main {
    public static void main(String[] argv) {
        int tree_num ;
        int workers_num = 3;
        String[] actions = {
                "копает яму",
                "сажает дерево",
                "подвязывает саженец к кольям",
        };
        CommonResource sync = new CommonResource();

        if (argv.length != 1) {
            throw new RuntimeException("You should set trees number");
        }

        try {
            tree_num = Integer.parseInt(argv[0]);
            if (tree_num <= 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            throw new RuntimeException("Trees number has to be an positive integer value");
        }

        Worker[] workers = new Worker[workers_num];
        for (int i = 0; i < workers_num; i++) {
            workers[i] = new Worker();
            workers[i].setNumber(i);
            workers[i].setAction(actions[i % (workers_num)]);
            workers[i].setTree_num(tree_num);
            workers[i].setSync(sync);
        }

        for (Worker worker : workers) {
            worker.start();
        }
    }
}
