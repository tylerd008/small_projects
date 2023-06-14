#include <stdio.h>

int main(){
    int c, blank, tab, nl;

    nl = blank = tab = 0;

    while ((c = getchar()) != EOF){
        if (c == ' ')
            blank++;
        else if (c == '\t')
            tab++;
        else if (c == '\n')
            nl++; 
    }

    printf("Blanks: %d\n", blank);
    printf("Tabs: %d\n", tab );
    printf("Newlines: %d\n", nl);

}