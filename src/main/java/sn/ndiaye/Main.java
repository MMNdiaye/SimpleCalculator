package sn.ndiaye;

import sn.ndiaye.domain.Controller;

public class Main {

    public static void main(String[] args) {
        int option = Integer.valueOf(args[0]);
        new Controller(option).start();
    }
}
