import java.text.DecimalFormat;

public class Main {
    public static final int PATIENT_COUNT = 30;
    public static final float MAX_TEMP = 40;
    public static final float MIN_TEMP = 32;
    public static final float MIN_TEMP_HEALTHY = 36.2F;
    public static final float MAX_TEMP_HEALTHY = 36.9F;
    public static void main(String[] args) {
        float[] temperature = new float[PATIENT_COUNT];
        float sumOfTemp = 0.0F;
        int helthyCount = 0;
        DecimalFormat formatter = new DecimalFormat("#0.00°C");
        System.out.print("Температура пациентов: ");
        for(int i = 0;i < temperature.length;i++)
        {
            temperature[i] = (float)(MIN_TEMP + (8 * Math.random()));
            sumOfTemp += temperature[i];
            if(temperature[i] > MIN_TEMP_HEALTHY && temperature[i] < MAX_TEMP_HEALTHY)
            {
                helthyCount++;
            }
            System.out.print(formatter.format(temperature[i]) + " ");
        }
        System.out.println("\n" + "Средняя температура: " + formatter.format(sumOfTemp / PATIENT_COUNT));
        System.out.println("Количество здоровых: " + helthyCount);
    }
}

