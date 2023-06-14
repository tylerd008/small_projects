#include <stdio.h>
#include <stdbool.h>
#define MAX_LINE 1000

int get_line(char line[], int maxline);
void copy(char to[], char from[]);
int get_comment_start(char s[], int len);
int get_comment_end(char s[], int len);
int remove_comment(char s[], int len, int start, int end);

int main()
{
    int len;
    int max;
    char line[MAX_LINE];
    int start, end;

    bool in_quote = false;
    while ((len = get_line(line, MAX_LINE)) > 0)
    {
        while ((start = get_comment_start(line, len)) /* yo */ != -1 || ((end = get_comment_end(line, len)) /* yo2 */ != -1)) /* yo 3*/
        {
            printf("%d, %d\n", start, end);
            len = remove_comment(line, len, start, end);
            printf("%s\n", line);
        }
        //printf("%s", line);
    }

    return 0;
}

int get_line(char s[], int lim)
{
    int c, i;

    for (i = 0; i < lim - 1 && (c = getchar()) != EOF && c != '\n'; ++i)
    {
        s[i] = c;
    }

    if (c == '\n')
    {
        s[i] = c;
        ++i;
    }

    s[i] = '\0';
    return i;
}

void copy(char to[], char from[])
{
    int i;

    i = 0;
    while ((to[i] = from[i]) != '\0')
    {
        ++i;
    }
}

int get_comment_start(char s[], int len)
{
    bool in_quote = false;
    for (int i = 0; i < len; i++)
    {
        if (s[i] == '"')
        {
            in_quote = !in_quote;
        }
        if (s[i] == '/' || s[i + 1] == '*' && !in_quote)
        {
            return i;
        }
    }
    return -1;
}

int get_comment_end(char s[], int len)
{
    bool in_quote = false;
    for (int i = 0; i < len; i++)
    {
        if (s[i] == '"')
        {
            in_quote = !in_quote;
        }
        if (s[i] == '*' && s[i + 1] == '/' && !in_quote)
        {
            printf("yo: %d\n", i);
            return i + 1;
        }
    }
    return -1;
}

int remove_comment(char s[], int len, int start, int end) //returns new len
{
    int distance;
    if (end != -1 && start == -1)
    {
        distance = end;
    }
    else
    {
        distance = end - start + 1;
        //printf("dis: %d", distance);
    }
    printf("start: %d, end: %d, len: %d\n", start, end, len);
    if ((end == -1 && start != -1) || ((end + 1) == len)) //if only has start of comment just cut off where the comment starts
    {
        printf("yo");
        s[start] = '\0';
        return len;
    }
    else
    {
        char temp[MAX_LINE];
        copy(temp, s);
        for (int i = start; i <= end; i++)
        {
            s[i] = temp[i + distance];
        }
    }
    return len - distance;
}
