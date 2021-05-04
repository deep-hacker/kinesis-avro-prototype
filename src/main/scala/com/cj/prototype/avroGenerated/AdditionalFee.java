/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.cj.prototype.avroGenerated;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class AdditionalFee extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -15669883545221282L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"AdditionalFee\",\"namespace\":\"com.cj.prototype.avroGenerated\",\"fields\":[{\"name\":\"amount\",\"type\":[\"null\",{\"type\":\"record\",\"name\":\"AmountWithCurrency\",\"fields\":[{\"name\":\"amount\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"currency\",\"type\":[\"null\",\"string\"],\"default\":null}]}],\"default\":null},{\"name\":\"id\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"name\",\"type\":[\"null\",\"string\"],\"default\":null}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<AdditionalFee> ENCODER =
      new BinaryMessageEncoder<AdditionalFee>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<AdditionalFee> DECODER =
      new BinaryMessageDecoder<AdditionalFee>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<AdditionalFee> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<AdditionalFee> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<AdditionalFee> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<AdditionalFee>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this AdditionalFee to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a AdditionalFee from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a AdditionalFee instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static AdditionalFee fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

   private com.cj.prototype.avroGenerated.AmountWithCurrency amount;
   private java.lang.CharSequence id;
   private java.lang.CharSequence name;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public AdditionalFee() {}

  /**
   * All-args constructor.
   * @param amount The new value for amount
   * @param id The new value for id
   * @param name The new value for name
   */
  public AdditionalFee(com.cj.prototype.avroGenerated.AmountWithCurrency amount, java.lang.CharSequence id, java.lang.CharSequence name) {
    this.amount = amount;
    this.id = id;
    this.name = name;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return amount;
    case 1: return id;
    case 2: return name;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: amount = (com.cj.prototype.avroGenerated.AmountWithCurrency)value$; break;
    case 1: id = (java.lang.CharSequence)value$; break;
    case 2: name = (java.lang.CharSequence)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'amount' field.
   * @return The value of the 'amount' field.
   */
  public com.cj.prototype.avroGenerated.AmountWithCurrency getAmount() {
    return amount;
  }


  /**
   * Sets the value of the 'amount' field.
   * @param value the value to set.
   */
  public void setAmount(com.cj.prototype.avroGenerated.AmountWithCurrency value) {
    this.amount = value;
  }

  /**
   * Gets the value of the 'id' field.
   * @return The value of the 'id' field.
   */
  public java.lang.CharSequence getId() {
    return id;
  }


  /**
   * Sets the value of the 'id' field.
   * @param value the value to set.
   */
  public void setId(java.lang.CharSequence value) {
    this.id = value;
  }

  /**
   * Gets the value of the 'name' field.
   * @return The value of the 'name' field.
   */
  public java.lang.CharSequence getName() {
    return name;
  }


  /**
   * Sets the value of the 'name' field.
   * @param value the value to set.
   */
  public void setName(java.lang.CharSequence value) {
    this.name = value;
  }

  /**
   * Creates a new AdditionalFee RecordBuilder.
   * @return A new AdditionalFee RecordBuilder
   */
  public static com.cj.prototype.avroGenerated.AdditionalFee.Builder newBuilder() {
    return new com.cj.prototype.avroGenerated.AdditionalFee.Builder();
  }

  /**
   * Creates a new AdditionalFee RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new AdditionalFee RecordBuilder
   */
  public static com.cj.prototype.avroGenerated.AdditionalFee.Builder newBuilder(com.cj.prototype.avroGenerated.AdditionalFee.Builder other) {
    if (other == null) {
      return new com.cj.prototype.avroGenerated.AdditionalFee.Builder();
    } else {
      return new com.cj.prototype.avroGenerated.AdditionalFee.Builder(other);
    }
  }

  /**
   * Creates a new AdditionalFee RecordBuilder by copying an existing AdditionalFee instance.
   * @param other The existing instance to copy.
   * @return A new AdditionalFee RecordBuilder
   */
  public static com.cj.prototype.avroGenerated.AdditionalFee.Builder newBuilder(com.cj.prototype.avroGenerated.AdditionalFee other) {
    if (other == null) {
      return new com.cj.prototype.avroGenerated.AdditionalFee.Builder();
    } else {
      return new com.cj.prototype.avroGenerated.AdditionalFee.Builder(other);
    }
  }

  /**
   * RecordBuilder for AdditionalFee instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<AdditionalFee>
    implements org.apache.avro.data.RecordBuilder<AdditionalFee> {

    private com.cj.prototype.avroGenerated.AmountWithCurrency amount;
    private com.cj.prototype.avroGenerated.AmountWithCurrency.Builder amountBuilder;
    private java.lang.CharSequence id;
    private java.lang.CharSequence name;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.cj.prototype.avroGenerated.AdditionalFee.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.amount)) {
        this.amount = data().deepCopy(fields()[0].schema(), other.amount);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (other.hasAmountBuilder()) {
        this.amountBuilder = com.cj.prototype.avroGenerated.AmountWithCurrency.newBuilder(other.getAmountBuilder());
      }
      if (isValidValue(fields()[1], other.id)) {
        this.id = data().deepCopy(fields()[1].schema(), other.id);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.name)) {
        this.name = data().deepCopy(fields()[2].schema(), other.name);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
    }

    /**
     * Creates a Builder by copying an existing AdditionalFee instance
     * @param other The existing instance to copy.
     */
    private Builder(com.cj.prototype.avroGenerated.AdditionalFee other) {
      super(SCHEMA$);
      if (isValidValue(fields()[0], other.amount)) {
        this.amount = data().deepCopy(fields()[0].schema(), other.amount);
        fieldSetFlags()[0] = true;
      }
      this.amountBuilder = null;
      if (isValidValue(fields()[1], other.id)) {
        this.id = data().deepCopy(fields()[1].schema(), other.id);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.name)) {
        this.name = data().deepCopy(fields()[2].schema(), other.name);
        fieldSetFlags()[2] = true;
      }
    }

    /**
      * Gets the value of the 'amount' field.
      * @return The value.
      */
    public com.cj.prototype.avroGenerated.AmountWithCurrency getAmount() {
      return amount;
    }


    /**
      * Sets the value of the 'amount' field.
      * @param value The value of 'amount'.
      * @return This builder.
      */
    public com.cj.prototype.avroGenerated.AdditionalFee.Builder setAmount(com.cj.prototype.avroGenerated.AmountWithCurrency value) {
      validate(fields()[0], value);
      this.amountBuilder = null;
      this.amount = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'amount' field has been set.
      * @return True if the 'amount' field has been set, false otherwise.
      */
    public boolean hasAmount() {
      return fieldSetFlags()[0];
    }

    /**
     * Gets the Builder instance for the 'amount' field and creates one if it doesn't exist yet.
     * @return This builder.
     */
    public com.cj.prototype.avroGenerated.AmountWithCurrency.Builder getAmountBuilder() {
      if (amountBuilder == null) {
        if (hasAmount()) {
          setAmountBuilder(com.cj.prototype.avroGenerated.AmountWithCurrency.newBuilder(amount));
        } else {
          setAmountBuilder(com.cj.prototype.avroGenerated.AmountWithCurrency.newBuilder());
        }
      }
      return amountBuilder;
    }

    /**
     * Sets the Builder instance for the 'amount' field
     * @param value The builder instance that must be set.
     * @return This builder.
     */

    public com.cj.prototype.avroGenerated.AdditionalFee.Builder setAmountBuilder(com.cj.prototype.avroGenerated.AmountWithCurrency.Builder value) {
      clearAmount();
      amountBuilder = value;
      return this;
    }

    /**
     * Checks whether the 'amount' field has an active Builder instance
     * @return True if the 'amount' field has an active Builder instance
     */
    public boolean hasAmountBuilder() {
      return amountBuilder != null;
    }

    /**
      * Clears the value of the 'amount' field.
      * @return This builder.
      */
    public com.cj.prototype.avroGenerated.AdditionalFee.Builder clearAmount() {
      amount = null;
      amountBuilder = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'id' field.
      * @return The value.
      */
    public java.lang.CharSequence getId() {
      return id;
    }


    /**
      * Sets the value of the 'id' field.
      * @param value The value of 'id'.
      * @return This builder.
      */
    public com.cj.prototype.avroGenerated.AdditionalFee.Builder setId(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.id = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'id' field has been set.
      * @return True if the 'id' field has been set, false otherwise.
      */
    public boolean hasId() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'id' field.
      * @return This builder.
      */
    public com.cj.prototype.avroGenerated.AdditionalFee.Builder clearId() {
      id = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'name' field.
      * @return The value.
      */
    public java.lang.CharSequence getName() {
      return name;
    }


    /**
      * Sets the value of the 'name' field.
      * @param value The value of 'name'.
      * @return This builder.
      */
    public com.cj.prototype.avroGenerated.AdditionalFee.Builder setName(java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.name = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'name' field has been set.
      * @return True if the 'name' field has been set, false otherwise.
      */
    public boolean hasName() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'name' field.
      * @return This builder.
      */
    public com.cj.prototype.avroGenerated.AdditionalFee.Builder clearName() {
      name = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public AdditionalFee build() {
      try {
        AdditionalFee record = new AdditionalFee();
        if (amountBuilder != null) {
          try {
            record.amount = this.amountBuilder.build();
          } catch (org.apache.avro.AvroMissingFieldException e) {
            e.addParentField(record.getSchema().getField("amount"));
            throw e;
          }
        } else {
          record.amount = fieldSetFlags()[0] ? this.amount : (com.cj.prototype.avroGenerated.AmountWithCurrency) defaultValue(fields()[0]);
        }
        record.id = fieldSetFlags()[1] ? this.id : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.name = fieldSetFlags()[2] ? this.name : (java.lang.CharSequence) defaultValue(fields()[2]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<AdditionalFee>
    WRITER$ = (org.apache.avro.io.DatumWriter<AdditionalFee>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<AdditionalFee>
    READER$ = (org.apache.avro.io.DatumReader<AdditionalFee>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    if (this.amount == null) {
      out.writeIndex(0);
      out.writeNull();
    } else {
      out.writeIndex(1);
      this.amount.customEncode(out);
    }

    if (this.id == null) {
      out.writeIndex(0);
      out.writeNull();
    } else {
      out.writeIndex(1);
      out.writeString(this.id);
    }

    if (this.name == null) {
      out.writeIndex(0);
      out.writeNull();
    } else {
      out.writeIndex(1);
      out.writeString(this.name);
    }

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      if (in.readIndex() != 1) {
        in.readNull();
        this.amount = null;
      } else {
        if (this.amount == null) {
          this.amount = new com.cj.prototype.avroGenerated.AmountWithCurrency();
        }
        this.amount.customDecode(in);
      }

      if (in.readIndex() != 1) {
        in.readNull();
        this.id = null;
      } else {
        this.id = in.readString(this.id instanceof Utf8 ? (Utf8)this.id : null);
      }

      if (in.readIndex() != 1) {
        in.readNull();
        this.name = null;
      } else {
        this.name = in.readString(this.name instanceof Utf8 ? (Utf8)this.name : null);
      }

    } else {
      for (int i = 0; i < 3; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          if (in.readIndex() != 1) {
            in.readNull();
            this.amount = null;
          } else {
            if (this.amount == null) {
              this.amount = new com.cj.prototype.avroGenerated.AmountWithCurrency();
            }
            this.amount.customDecode(in);
          }
          break;

        case 1:
          if (in.readIndex() != 1) {
            in.readNull();
            this.id = null;
          } else {
            this.id = in.readString(this.id instanceof Utf8 ? (Utf8)this.id : null);
          }
          break;

        case 2:
          if (in.readIndex() != 1) {
            in.readNull();
            this.name = null;
          } else {
            this.name = in.readString(this.name instanceof Utf8 ? (Utf8)this.name : null);
          }
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}









