#include <stdio.h>
#define MAXLINE 1000

int gettline(char line[], int maxline);
void reverse(char s[], int len);
void copy(char to[], char from[]);

int main(){
    int len;
    char line[MAXLINE];

    
    while ((len = gettline(line, MAXLINE)) > 0){
        reverse(line, len);
        printf("%s", line);
    }

    return 0;
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

void copy(char to[], char from[]){
    int i;

    i = 0;
    while((to[i] = from[i]) != '\0'){
        ++i;
    }
}

void reverse(char s[], int len){
    char temp[len];

    for (int i = 0; i < len; i++){
        temp[i] = s[len - i - 1];
    }
    temp[len] = '\0';

    copy(s, temp);
}
