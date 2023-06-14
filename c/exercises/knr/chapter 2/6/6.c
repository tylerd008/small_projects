#include <stdio.h>

unsigned getbits(unsigned x, int p, int n);
unsigned setbits(unsigned x, int p, int n, unsigned y);
int main()
{
    unsigned asdf = setbits(228, 3, 2, 10); //11100100 00001010 -> 11101000
    printf("%d", asdf);
    return 0;
}

unsigned getbits(unsigned x, int p, int n)
{
    return (x >> (p + 1 - n)) & ~(~0 << n);
}

unsigned setbits(unsigned x, int p, int n, unsigned y)
{
    unsigned mask = getbits(y, n - 1, n);
    printf("mask: %u\n", mask);
    return ~(x ^ ~(mask << p - 1));
}