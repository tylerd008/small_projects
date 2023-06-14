#include <stdio.h>

#define N 10

int main(){

    char s[N], *p, c;
    int i;
    
    printf("Enter a string up to 10 char:");
    for (p = s; (p < s + N) && ((c = getchar()) != '\n'); p++)
        *p = c;
    for (p--; p >= s; p--)
        printf("%c", *p);

    return 0;
}