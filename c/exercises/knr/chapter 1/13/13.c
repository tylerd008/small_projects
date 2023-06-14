#include <stdio.h>

#define IN 1
#define OUT 0

int main() {
    int c, wl, state;
    int wlfreq[15];//word lengths up to 14 characters

    wl = 0;
    state = OUT;

    for (int i = 0; i < 15; i ++){
        wlfreq[i] = 0;
    }

    while((c = getchar()) != EOF){
        if(c == ' ' || c == '\n' || c == '\t'){
            state = OUT;
        }
        else if (state == OUT){
            state = IN;
            if (wl > 0){
                wlfreq[wl]++;
            }
            wl = 1;
        }
        else if (state == IN){
            wl++;
        }
    }
    if (wl > 0){
         wlfreq[wl]++;
    }

    for (int i = 1; i < 15; i++){
        printf("%2d char length words: ", i);
        for (int j = 1; j <= wlfreq[i]; j++){
            putchar('-');
        }
        putchar('\n');
    }
}