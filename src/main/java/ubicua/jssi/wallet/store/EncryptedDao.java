/*
 * The MIT License
 *
 * Copyright 2019 ITON Solutions.
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
package ubicua.jssi.wallet.store;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.UpdateBuilder;
import ubicua.jssi.wallet.model.Encrypted;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EncryptedDao implements Serializable {

    private static final Logger LOG = LoggerFactory.getLogger(EncryptedDao.class);
    private Dao<Encrypted, Void> dao = null;

    public EncryptedDao(){
        try{
            dao = DaoManager.createDao(StoreHelper.getSource(), Encrypted.class);
        } catch(SQLException e){
            LOG.error(String.format("Error: %s", e));
        }
    }

    public int create(Encrypted encrypted)  {
        int result = 0;
        try {
            result = dao.create(encrypted);
        } catch(SQLException e){
            LOG.error(String.format("Error: %s", e.getCause().getMessage()));
        }
        return result;
    }

    public int create(Collection<Encrypted> encrypted)  {
        int result = 0;
        try {
            result = dao.create(encrypted);
        } catch(SQLException e){
            LOG.error(String.format("Error: %s", e.getCause().getMessage()));
        }
        return result;
    }

    public int delete(Collection<Encrypted> encrypted)  {
        int result = 0;
        try {
            for(Encrypted element : encrypted) {
                DeleteBuilder<Encrypted, Void> builder = dao.deleteBuilder();
                builder.where()
                        .eq("item_id", element.getItem().getId())
                        .and()
                        .eq("name", element.getName());
                result = dao.delete(builder.prepare());
            }
        } catch(SQLException e){
            LOG.error(String.format("Error: %s", e.getCause().getMessage()));
        }
        return result;
    }

    public int update(Collection<Encrypted> encrypted)  {
        int result = 0;
        try {
            for(Encrypted element : encrypted) {
                UpdateBuilder<Encrypted, Void> builder = dao.updateBuilder();
                builder.updateColumnValue("value", element.getValue());
                builder.where()
                        .eq("item_id", element.getItem().getId())
                        .and()
                        .eq("name", element.getName());
                result += dao.update(builder.prepare());
            }
        } catch(SQLException e){
            LOG.error(String.format("Error: %s", e));
        }
        return result;
    }

    public List<Encrypted> queryForAll() {
        List<Encrypted> result = new ArrayList<>();
        try {
            result = dao.queryForAll();
        } catch(SQLException e){
            LOG.error(String.format("Error: %s", e));
        }
        return result;
    }

     public int getCount() {
        int result = 0;
        try {
            result = (int) dao.countOf();
        } catch(SQLException e){
            LOG.error(String.format("Error: %s", e));
        }
        return result;
    }
}
