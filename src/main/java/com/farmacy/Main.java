package com.farmacy;

import javax.swing.SwingUtilities;

import com.farmacy.infrastructure.PharmacyUI;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                SwingUtilities.invokeLater(PharmacyUI::new);
            }
        });
    }
}
