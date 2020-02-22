class Song
{
public:
    char song_name[];
    float duration;
    char artist[];
    int song_index;
    Song(char name, float duration, char artist[], int song_index)
    {
        this.songname = name;
        this.duration = duration;
        this.artist = artist;
        this.song_index = song_index;
    }
};
