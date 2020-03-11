package com.sxlg.goblet.hash;

public class Hash {

    public static long APHash(String key, int slotNumber) {
        long hash = 0xAAAAAAAA;

        for (int i = 0; i < key.length(); i++) {
            if ((i & 1) == 0) {
                hash ^= ((hash << 7) ^ key.charAt(i) * (hash >> 3));
            } else {
                hash ^= (~((hash << 11) + key.charAt(i) ^ (hash >> 5)));
            }
        }

        return (int) (hash & (slotNumber - 1));
    }

    public static long DEKHash(String key, int slotNumber) {
        long hash = key.length();

        for (int i = 0; i < key.length(); i++) {
            hash = ((hash << 5) ^ (hash >> 27)) ^ key.charAt(i);
        }

        return (int) (hash & (slotNumber - 1));
    }
}
