#include <limits.h>
#include <float.h>
#include <stdio.h>

int main()
{
    printf("char_bit: %d\n", CHAR_BIT);
    printf("char min: %d\n", CHAR_MIN);
    printf("char max: %d\n", CHAR_MAX);
    printf("unsigned char max: %u\n", UCHAR_MAX);
    printf("short min: %d\n", SHRT_MIN);
    printf("short max: %d\n", SHRT_MAX);
    printf("unsigned short max: %u\n", USHRT_MAX);
    printf("int min: %d\n", INT_MIN);
    printf("int max: %d\n", INT_MAX);
    printf("unsigned int max: %u\n", UINT_MAX);
    printf("long min: %ld\n", LONG_MIN);
    printf("long max: %ld\n", LONG_MAX);
    printf("unsigned long max: %u\n", ULONG_MAX);
    printf("float min: %f\n", FLT_MIN);
    printf("float max: %f\n", FLT_MAX);
    printf("double min: %g\n", DBL_MIN);
    printf("double max: %g\n", DBL_MAX);
    return 0;
}