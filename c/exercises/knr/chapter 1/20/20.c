#include <stdio.h>
#define MAX_LINE 1000
#define TAB_BLANKS 3

int gettline(char line[], int maxline);
void copy(char to[], char from[]);
void detab(char s[], int len);
int tabcount(char s[], int len);
void stringshift(char s[], int index, int len);

int main()
{
    int len;
    char line[MAX_LINE];

    while ((len = gettline(line, MAX_LINE)) > 0)
    {
        detab(line, len);
        printf("%s", line);
    }

    return 0;
}

int gettline(char s[], int lim)
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

void detab(char s[], int len)
{
    int tabs = tabcount(s, len);
    int extra_spaces = (TAB_BLANKS * tabs) - tabs;
    int new_len = len;
    if (MAX_LINE < len + extra_spaces)
    {
        printf("Line is too long to detab");
        return;
    }
    printf("yo: %s\n", s);
    for (int i = 0; i < len + extra_spaces; i++)
    {
        if (s[i] == '\t')
        { //why doesnt this line work
            stringshift(s, i, new_len);
            new_len += TAB_BLANKS;
        }
    }
}

int tabcount(char s[], int len)
{
    int count = 0;
    for (int i = 0; i < len; i++)
    {
        if (s[i] == '\t')
        {
            printf("yo");
            count++;
        }
    }
    return count;
}

void stringshift(char s[], int index, int len)
{
    char temp[MAX_LINE];
    copy(temp, s);
    for (int i = len; i >= index + TAB_BLANKS; i--)
    {
        s[i + TAB_BLANKS] = temp[i];
    }
    for (int i = index; i < index + TAB_BLANKS; i++)
    {
        s[i] = 'a';
    }
}