// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: user.proto

package com.mdp.grpc;

/**
 * Protobuf type {@code RadiiResponse}
 */
public  final class RadiiResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:RadiiResponse)
    RadiiResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use RadiiResponse.newBuilder() to construct.
  private RadiiResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private RadiiResponse() {
    radii_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private RadiiResponse(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 9: {
            if (!((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
              radii_ = new java.util.ArrayList<java.lang.Double>();
              mutable_bitField0_ |= 0x00000001;
            }
            radii_.add(input.readDouble());
            break;
          }
          case 10: {
            int length = input.readRawVarint32();
            int limit = input.pushLimit(length);
            if (!((mutable_bitField0_ & 0x00000001) == 0x00000001) && input.getBytesUntilLimit() > 0) {
              radii_ = new java.util.ArrayList<java.lang.Double>();
              mutable_bitField0_ |= 0x00000001;
            }
            while (input.getBytesUntilLimit() > 0) {
              radii_.add(input.readDouble());
            }
            input.popLimit(limit);
            break;
          }
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      if (((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
        radii_ = java.util.Collections.unmodifiableList(radii_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.mdp.grpc.User.internal_static_RadiiResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.mdp.grpc.User.internal_static_RadiiResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.mdp.grpc.RadiiResponse.class, com.mdp.grpc.RadiiResponse.Builder.class);
  }

  public static final int RADII_FIELD_NUMBER = 1;
  private java.util.List<java.lang.Double> radii_;
  /**
   * <pre>
   * Array of available turn radii.
   * The first value is +inf for straight line motion.
   * </pre>
   *
   * <code>repeated double radii = 1;</code>
   */
  public java.util.List<java.lang.Double>
      getRadiiList() {
    return radii_;
  }
  /**
   * <pre>
   * Array of available turn radii.
   * The first value is +inf for straight line motion.
   * </pre>
   *
   * <code>repeated double radii = 1;</code>
   */
  public int getRadiiCount() {
    return radii_.size();
  }
  /**
   * <pre>
   * Array of available turn radii.
   * The first value is +inf for straight line motion.
   * </pre>
   *
   * <code>repeated double radii = 1;</code>
   */
  public double getRadii(int index) {
    return radii_.get(index);
  }
  private int radiiMemoizedSerializedSize = -1;

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    getSerializedSize();
    if (getRadiiList().size() > 0) {
      output.writeUInt32NoTag(10);
      output.writeUInt32NoTag(radiiMemoizedSerializedSize);
    }
    for (int i = 0; i < radii_.size(); i++) {
      output.writeDoubleNoTag(radii_.get(i));
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    {
      int dataSize = 0;
      dataSize = 8 * getRadiiList().size();
      size += dataSize;
      if (!getRadiiList().isEmpty()) {
        size += 1;
        size += com.google.protobuf.CodedOutputStream
            .computeInt32SizeNoTag(dataSize);
      }
      radiiMemoizedSerializedSize = dataSize;
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.mdp.grpc.RadiiResponse)) {
      return super.equals(obj);
    }
    com.mdp.grpc.RadiiResponse other = (com.mdp.grpc.RadiiResponse) obj;

    boolean result = true;
    result = result && getRadiiList()
        .equals(other.getRadiiList());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (getRadiiCount() > 0) {
      hash = (37 * hash) + RADII_FIELD_NUMBER;
      hash = (53 * hash) + getRadiiList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.mdp.grpc.RadiiResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.mdp.grpc.RadiiResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.mdp.grpc.RadiiResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.mdp.grpc.RadiiResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.mdp.grpc.RadiiResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.mdp.grpc.RadiiResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.mdp.grpc.RadiiResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.mdp.grpc.RadiiResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.mdp.grpc.RadiiResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.mdp.grpc.RadiiResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.mdp.grpc.RadiiResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.mdp.grpc.RadiiResponse parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.mdp.grpc.RadiiResponse prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code RadiiResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:RadiiResponse)
      com.mdp.grpc.RadiiResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.mdp.grpc.User.internal_static_RadiiResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.mdp.grpc.User.internal_static_RadiiResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.mdp.grpc.RadiiResponse.class, com.mdp.grpc.RadiiResponse.Builder.class);
    }

    // Construct using com.mdp.grpc.RadiiResponse.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      radii_ = java.util.Collections.emptyList();
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.mdp.grpc.User.internal_static_RadiiResponse_descriptor;
    }

    @java.lang.Override
    public com.mdp.grpc.RadiiResponse getDefaultInstanceForType() {
      return com.mdp.grpc.RadiiResponse.getDefaultInstance();
    }

    @java.lang.Override
    public com.mdp.grpc.RadiiResponse build() {
      com.mdp.grpc.RadiiResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.mdp.grpc.RadiiResponse buildPartial() {
      com.mdp.grpc.RadiiResponse result = new com.mdp.grpc.RadiiResponse(this);
      int from_bitField0_ = bitField0_;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        radii_ = java.util.Collections.unmodifiableList(radii_);
        bitField0_ = (bitField0_ & ~0x00000001);
      }
      result.radii_ = radii_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return (Builder) super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.mdp.grpc.RadiiResponse) {
        return mergeFrom((com.mdp.grpc.RadiiResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.mdp.grpc.RadiiResponse other) {
      if (other == com.mdp.grpc.RadiiResponse.getDefaultInstance()) return this;
      if (!other.radii_.isEmpty()) {
        if (radii_.isEmpty()) {
          radii_ = other.radii_;
          bitField0_ = (bitField0_ & ~0x00000001);
        } else {
          ensureRadiiIsMutable();
          radii_.addAll(other.radii_);
        }
        onChanged();
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.mdp.grpc.RadiiResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.mdp.grpc.RadiiResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.util.List<java.lang.Double> radii_ = java.util.Collections.emptyList();
    private void ensureRadiiIsMutable() {
      if (!((bitField0_ & 0x00000001) == 0x00000001)) {
        radii_ = new java.util.ArrayList<java.lang.Double>(radii_);
        bitField0_ |= 0x00000001;
       }
    }
    /**
     * <pre>
     * Array of available turn radii.
     * The first value is +inf for straight line motion.
     * </pre>
     *
     * <code>repeated double radii = 1;</code>
     */
    public java.util.List<java.lang.Double>
        getRadiiList() {
      return java.util.Collections.unmodifiableList(radii_);
    }
    /**
     * <pre>
     * Array of available turn radii.
     * The first value is +inf for straight line motion.
     * </pre>
     *
     * <code>repeated double radii = 1;</code>
     */
    public int getRadiiCount() {
      return radii_.size();
    }
    /**
     * <pre>
     * Array of available turn radii.
     * The first value is +inf for straight line motion.
     * </pre>
     *
     * <code>repeated double radii = 1;</code>
     */
    public double getRadii(int index) {
      return radii_.get(index);
    }
    /**
     * <pre>
     * Array of available turn radii.
     * The first value is +inf for straight line motion.
     * </pre>
     *
     * <code>repeated double radii = 1;</code>
     */
    public Builder setRadii(
        int index, double value) {
      ensureRadiiIsMutable();
      radii_.set(index, value);
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Array of available turn radii.
     * The first value is +inf for straight line motion.
     * </pre>
     *
     * <code>repeated double radii = 1;</code>
     */
    public Builder addRadii(double value) {
      ensureRadiiIsMutable();
      radii_.add(value);
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Array of available turn radii.
     * The first value is +inf for straight line motion.
     * </pre>
     *
     * <code>repeated double radii = 1;</code>
     */
    public Builder addAllRadii(
        java.lang.Iterable<? extends java.lang.Double> values) {
      ensureRadiiIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, radii_);
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Array of available turn radii.
     * The first value is +inf for straight line motion.
     * </pre>
     *
     * <code>repeated double radii = 1;</code>
     */
    public Builder clearRadii() {
      radii_ = java.util.Collections.emptyList();
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:RadiiResponse)
  }

  // @@protoc_insertion_point(class_scope:RadiiResponse)
  private static final com.mdp.grpc.RadiiResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.mdp.grpc.RadiiResponse();
  }

  public static com.mdp.grpc.RadiiResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<RadiiResponse>
      PARSER = new com.google.protobuf.AbstractParser<RadiiResponse>() {
    @java.lang.Override
    public RadiiResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new RadiiResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<RadiiResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<RadiiResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.mdp.grpc.RadiiResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

