package org.dinhware.hiscore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by: Niklas
 * Date: 26.11.2016
 * Alias: Dinh
 * Time: 19:06
 */

public class Hiscore {

    private final String ENDPOINT = "http://services.runescape.com/m=hiscore_oldschool/index_lite.ws?player=";

    private String ingameName;
    private int[][] hiscoreArray;

    public Hiscore(String ingameName) throws IOException {
        this.ingameName = ingameName;
        this.hiscoreArray = getInfo();
    }

    private int[][] getInfo() throws IOException {
        URL url = new URL(ENDPOINT + ingameName.replace(" ", "%20"));
        URLConnection urlConnection = url.openConnection();
        int[][] responseArray = new int[24][3];
        try (BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()))) {
            for (int i = 0; i < responseArray.length - 1; i++) {
                String line = in.readLine();
                int firstCommaIndex = line.indexOf(",");
                int secondCommaIndex = line.indexOf(",", +firstCommaIndex + 1);
                responseArray[i][0] = Integer.parseInt(line.substring(0, firstCommaIndex));
                responseArray[i][1] = Integer.parseInt(line.substring(firstCommaIndex + 1, secondCommaIndex));
                responseArray[i][2] = Integer.parseInt(line.substring(secondCommaIndex + 1));
            }
        }
        return responseArray;
    }

    public String getIngameName() {
        return ingameName;
    }

    public int getRank(int index) {
        return hiscoreArray[index][0];
    }

    public int getLevel(int index) {
        return hiscoreArray[index][1];
    }

    public int getExperience(int index) {
        return hiscoreArray[index][2];
    }

    public int getRank(HiscoreSkill skill) {
        return hiscoreArray[skill.getIndex()][0];
    }

    public int getLevel(HiscoreSkill skill) {
        return hiscoreArray[skill.getIndex()][1];
    }

    public int getExperience(HiscoreSkill skill) {
        return hiscoreArray[skill.getIndex()][2];
    }
}