package com.dl.common.framework.shiro.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

public class SerializeUtils<T> implements RedisSerializer<T> {

	private static Logger logger = LoggerFactory.getLogger(SerializeUtils.class);

	public static boolean isEmpty(byte[] data) {
		return (data == null || data.length == 0);
	}

	/**
	 * 序列化
	 * 
	 * @param object
	 * @return
	 * @throws SerializationException
	 */
	@Override
	public byte[] serialize(T object) throws SerializationException {
		byte[] result = null;

		if (object == null) {
			return new byte[0];
		}
		try (ByteArrayOutputStream byteStream = new ByteArrayOutputStream(128);
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteStream)) {
			if (!(object instanceof Serializable)) {
				throw new IllegalArgumentException(
						SerializeUtils.class.getSimpleName() + " requires a Serializable payload "
								+ "but received an object of type [" + object.getClass().getName() + "]");
			}
			objectOutputStream.writeObject(object);
			objectOutputStream.flush();
			result = byteStream.toByteArray();
		} catch (Exception ex) {
			logger.error("Failed to serialize", ex);
		}
		return result;
	}

	/**
	 * 反序列化
	 * 
	 * @param bytes
	 * @return
	 * @throws SerializationException
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T deserialize(byte[] bytes) throws SerializationException {
		T result = null;
		if (isEmpty(bytes)) {
			return null;
		}
		try (ByteArrayInputStream byteStream = new ByteArrayInputStream(bytes);
				ObjectInputStream objectInputStream = new ObjectInputStream(byteStream)) {
			result = (T) objectInputStream.readObject();
		} catch (Exception e) {
			logger.error("Failed to deserialize", e);
		}
		return result;
	}

	/*@Override
	public T deserialize(byte[] arg0) throws SerializationException {
		// TODO Auto-generated method stub
		return null;
	}*/

	/*@Override
	public byte[] serialize(T arg0) throws SerializationException {
		// TODO Auto-generated method stub
		return null;
	}*/

}
