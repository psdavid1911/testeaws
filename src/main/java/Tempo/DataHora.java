/*
 * The MIT License
 *
 * Copyright 2018 psdav.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package Tempo;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Objects;

/**
 *
 * @author psdav
 */
public class DataHora {
    LocalDateTime DataHora;

    public DataHora(int dia, Month mes, int ano, int hora, int minutos) {
        this.DataHora = LocalDateTime.of(ano, mes, dia, hora, minutos);
    }
    
    public DataHora(int hora, int minutos){
        this.DataHora = LocalDateTime.of(2018, Month.APRIL, 1, hora, minutos);
    }

    public LocalDateTime getHora() {
        return DataHora;
    }

    @Override
    public String toString() {
        return "DataHora{" + "DataHora=" + DataHora + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DataHora other = (DataHora) obj;
        if (!Objects.equals(this.DataHora, other.DataHora)) {
            return false;
        }
        return true;
    }
    
    
}
