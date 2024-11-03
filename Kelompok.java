package TugasArray;

import java.util.Scanner;

    class Queue {
    private String[] mahasiswa;
    private int[] nilai;
    private int front, rear, capacity, size;

    public Queue(int capacity) {
        this.capacity = capacity;
        mahasiswa = new String[capacity];
        nilai = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(String nama, int nilaiMahasiswa) {
        if (size == capacity) {
            System.out.println("Queue penuh! Tidak dapat menambahkan data.");
            return;
        }
        rear = (rear + 1) % capacity;
        mahasiswa[rear] = nama;
        nilai[rear] = nilaiMahasiswa;
        size++;
    }

    public void display() {
        System.out.println("\nDaftar Mahasiswa: ");
        System.out.println("===================================================================");
        System.out.println("No \t\t Nama  \t\t Nilai \t\t Keterangan");
        System.out.println("-------------------------------------------------------------------");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % capacity;
            String keterangan = (nilai[index] >= 75) ? "Lulus" : "Tidak Lulus";
            System.out.println((i + 1) + "\t\t" + mahasiswa[index] + "\t\t" + nilai[index] + "\t\t" + keterangan);
        }
        System.out.println("===================================================================");
    }

    public double calculateAverage() {
        double jumlah = 0;
        for (int i = 0; i < size; i++) {
            int index = (front + i) % capacity;
            jumlah += nilai[index];
        }
        return jumlah / size;
    }

    public int getSize() {
        return size;
    }
}

public class Kelompok {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue queue = new Queue(100);

        String inputData = "y";
        do {
            System.out.print("Masukkan nama: ");
            String nama = sc.nextLine();

            System.out.print("Masukkan nilai: ");
            int nilaiMahasiswa = sc.nextInt();
            sc.nextLine();

            queue.enqueue(nama, nilaiMahasiswa);

            System.out.print("Input lagi?: (y/n) ");
            inputData = sc.nextLine();
        } while (inputData.equalsIgnoreCase("y"));

        System.out.println("\nMasukkan jumlah data: " + queue.getSize());

        queue.display();

        double rata2 = queue.calculateAverage();
        System.out.println("Nilai rata-rata:  " + rata2);
        
        sc.close();
    }
}