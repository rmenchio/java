package org.example.P3516;

public class Solution {
    public int findClosest(int x, int y, int z) {
        var distanciaXZ = Math.abs(z - x);
        var distanciaYZ = Math.abs(z - y);

        return distanciaXZ < distanciaYZ ? 1 : distanciaXZ > distanciaYZ ? 2 : 0;
    }
}