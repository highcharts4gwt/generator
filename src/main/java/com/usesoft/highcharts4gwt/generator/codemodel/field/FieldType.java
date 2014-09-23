package com.usesoft.highcharts4gwt.generator.codemodel.field;

import javax.annotation.CheckForNull;

public enum FieldType
{
    Number
    {

        @CheckForNull
        @Override
        public <IN, OUT> OUT accept(FieldTypeVisitor<IN, OUT> visitor, IN in)
        {
            return visitor.visitNumber(in);
        }

    },
    Boolean
    {

        @CheckForNull
        @Override
        public <IN, OUT> OUT accept(FieldTypeVisitor<IN, OUT> visitor, IN in)
        {
            return visitor.visitBoolean(in);
        }

    },
    String
    {

        @CheckForNull
        @Override
        public <IN, OUT> OUT accept(FieldTypeVisitor<IN, OUT> visitor, IN in)
        {
            return visitor.visitString(in);
        }

    },
    Class
    {
        @Override
        @CheckForNull
        public <IN, OUT> OUT accept(FieldTypeVisitor<IN, OUT> visitor, IN in)
        {
            return visitor.visitClass(in);
        }
    },
    ArrayString
    {

        @CheckForNull
        @Override
        public <IN, OUT> OUT accept(FieldTypeVisitor<IN, OUT> visitor, IN in)
        {
            return visitor.visitArrayString(in);
        }

    },
    ArrayNumber
    {
        @Override
        @CheckForNull
        public <IN, OUT> OUT accept(FieldTypeVisitor<IN, OUT> visitor, IN in)
        {
            return visitor.visitArrayNumber(in);
        }
    },
    ArrayObject
    {
        @Override
        @CheckForNull
        public <IN, OUT> OUT accept(FieldTypeVisitor<IN, OUT> visitor, IN in)
        {
            return visitor.visitArrayObject(in);
        }
    },
    Other
    {
        @Override
        @CheckForNull
        public <IN, OUT> OUT accept(FieldTypeVisitor<IN, OUT> visitor, IN in)
        {
            return visitor.visitOther(in);
        }
    },
    Data
    {
        @Override
        @CheckForNull
        public <IN, OUT> OUT accept(FieldTypeVisitor<IN, OUT> visitor, IN in)
        {
            return visitor.visitData(in);
        }
    };

    @CheckForNull
    public abstract <IN, OUT> OUT accept(FieldTypeVisitor<IN, OUT> visitor, IN in);

}
