#include <stdio.h>
#include <string.h>

int any(char s1[], char s2[]);
int any2(char s1[], char s2[]);

int main()
{
    printf("%d\n", any("dog", "cat"));
    printf("%d\n", any("town", "can"));
    return 0;
}

int any(char s1[], char s2[])
{
    for (int i = 0; s1[i] != '\0'; i++)
    {
        for (int j = 0; s2[j] != '\0'; j++)
        {
            if (s1[i] == s2[j])
            {
                return i;
            }
        }
    }
    return -1;
}

int any2(char s1[], char s2[])
{
    int i, j;
    i = j = 0;

    while (s1[i] != '\0')
    {
        while (s2[j] != '\0')
        {
            if (s1[i] == s2[j])
            {
                return i;
            }
            j++;
        }
        i++;
    }
}