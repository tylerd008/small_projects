#include <stdio.h>

void squeeze(char s[], int c);
void strsqueeze(char s1[], char s2[]);
int main()
{
    char s1[] = "house";
    char s2[] = "mouse";
    strsqueeze(s1, s2);
    printf("%s", s1);
    return 0;
}

void strsqueeze(char s1[], char s2[])
{
    for (int i = 0; s2[i] != '\0'; i++)
    {
        squeeze(s1, s2[i]);
    }
}

void squeeze(char s[], int c)
{
    int i, j;

    for (i = j = 0; s[i] != '\0'; i++)
    {
        if (s[i] != c)
        {
            s[j++] = s[i];
        }
        s[j] = '\0';
    }
}