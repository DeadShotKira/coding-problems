            if (map1.containsKey(ch) && !map1.get(ch).equals(word)) {
                return false;
            }

            if (map2.containsKey(word) && map2.get(word) != ch) {
                return false;
            }

            map1.put(ch, word);
            map2.put(word, ch);
        }

        return true;
    }
}
