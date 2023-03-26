public interface Field<T> {
    T plus(T x, T y); // la somma

    T times(T x, T y); // il prodotto

    T getOne(); // restituisce l ’ elemento neutro per il prodotto

    T getZero(); // restituisce l ’elemento neutro per la somma
}
