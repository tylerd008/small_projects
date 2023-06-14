#include <stdio.h>

unsigned getbits(unsigned x, int p, int n);
unsigned invert(unsigned x, int p, int n);

int main()
{
    unsigned a = invert(10, 3, 2); //1010

    printf("%u", a);
    return 0;
}

unsigned getbits(unsigned x, int p, int n)
{
    return (x >> (p + 1 - n)) & ~(~0 << n); // 2 & 7
}

unsigned invert(unsigned x, int p, int n)
{
    unsigned mask = getbits(x, p, n);
    printf("mask: %u\n", mask);
    printf("inv mask: %u\n", ~mask);
    return ~(x ^ ~(mask << p - 1));
}