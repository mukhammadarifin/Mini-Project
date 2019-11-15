package com.example.restoran;

public class Menu {

    public String namaMenu;
    public String deskripsiMenu;
    public int hargaMenu;
    public int gambar;

    public Menu(String namaMenu, String deskripsiMenu, int hargaMenu, int gambar) {
        this.namaMenu = namaMenu;
        this.deskripsiMenu = deskripsiMenu;
        this.hargaMenu = hargaMenu;
        this.gambar = gambar;
    }

    public String getNamaMenu() {
        return namaMenu;
    }

    public void setNamaMenu(String namaMenu) {
        this.namaMenu = namaMenu;
    }

    public String getDeskripsiMenu() {
        return deskripsiMenu;
    }

    public void setDeskripsiMenu(String deskripsiMenu) {
        this.deskripsiMenu = deskripsiMenu;
    }

    public int getHargaMenu() {
        return hargaMenu;
    }

    public void setHargaMenu(int hargaMenu) {
        this.hargaMenu = hargaMenu;
    }

    public int getGambar() {
        return gambar;
    }

    public void setGambar(int gambar) {
        this.gambar = gambar;
    }
}
