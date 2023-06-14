#include <stdio.h>
#define MAX_LINE 1000
#define MAX_LINE_DISP 80

int gettline(char line[], int maxline);
void copy(char to[], char from[]);
void addcharat(char s[], char c, int index, int len);
int getlastblank(char s[], int len);
int getdashpos(int elen);

int main()
{
    int elen, len;
    char line[MAX_LINE];

    while ((len = gettline(line, MAX_LINE)) > 0)
    {
        elen = len;
        while (elen >= MAX_LINE_DISP)
        {
            int lastblank = getlastblank(line, elen);
            if (lastblank != -1)
            {
                if (len + 1 > MAX_LINE)
                {
                    printf("Line too long");
                    goto loopend;
                }
                addcharat(line, '\n', lastblank + 1, len);
                len += 1;
                elen = lastblank;
            }
            else
            {
                int dpos = getdashpos(elen);
                if (dpos != 0)
                {
                    if (len + 2 > MAX_LINE)
                    {
                        printf("Line too long");
                        goto loopend;
                    }
                    printf("%d\n", dpos);
                    addcharat(line, '-', dpos, len);
                    addcharat(line, '\n', dpos + 1, len + 1);
                    len += 2;
                }
                elen = dpos;
            }
        }
    loopend:
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

void addcharat(char s[], char c, int index, int len)
{
    char temp[MAX_LINE];
    copy(temp, s);
    for (int i = index; i < len; i++)
    {
        s[i + 1] = temp[i];
    }
    s[len + 1] = '\0';
    s[index] = c;
}

int getlastblank(char s[], int len)
{
    int lastblank = -1;
    for (int i = 0; i < len; i++)
    {
        if (s[i] == ' ' || s[i] == '\t')
        {
            lastblank = i;
        }
    }

    return lastblank;
}

int getdashpos(int elen)
{
    int pos = 0;
    while (elen - pos > MAX_LINE_DISP)
    {
        pos += MAX_LINE_DISP;
    }
    return pos;
}