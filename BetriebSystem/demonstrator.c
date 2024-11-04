#include <stdio.h>


void printer(int pos, int value) {
  printf("pos=%d, val=%d\n", pos, value);
}


void iterate(int *array, int size, void(*func)(int , int)) {
  for(int i = 0; i < size; i++){
    func(i,array[i]);
  }
}



int main() {
  int numbers[] = {1, 53, 2, 567, 75, 33};
  int size = sizeof(numbers)/sizeof(int);

  // call iterator with printer
  iterate(numbers, size, printer);

}
