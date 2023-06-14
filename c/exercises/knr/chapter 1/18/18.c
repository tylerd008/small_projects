#include <stdio.h>
#define MAXLINE 1000

int gettline(char line[], int maxline);

int main(){
    int len, lnb;
    char line[MAXLINE];

    lnb = 0;

    while ((len = gettline(line, MAXLINE)) > 0){
        for (int i = 0; i < len; i++){
            if ((line[i] != '\t') && (line[i] != ' ')){
                lnb = i;
            }
        }
        if(line[0] == '\n'){
            line[0] = '\0';
        }else {
            line[lnb+1] = '\0';
        }
        printf("%s", line);
    }
}

int gettline(char s[], int lim){
    int c, i;

    for (i = 0; i< lim - 1 && (c = getchar()) != EOF && c != '\n'; ++i){
        s[i] = c;
    }

    if (c == '\n'){
        s[i] = c;
        ++i;
    }

    s[i] = '\0';
    return i;
}