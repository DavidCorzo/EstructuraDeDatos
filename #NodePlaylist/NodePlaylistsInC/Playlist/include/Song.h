#ifndef SONG_H
#define SONG_H


class Song
{
public:
    char song_name[];
    char artist[];
    int song_index;
    Song(char name, char artist[], int song_index)
    {
        this.songname = name;
        this.artist = artist;
        this.song_index = song_index;
    }

    void getSongName() {
        printf("");
    }
};

#endif // SONG_H
